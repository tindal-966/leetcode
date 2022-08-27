#!/bin/bash
set -e

pushd `dirname $0` > /dev/null
SCRIPT_PATH=`pwd -P`
popd > /dev/null
SCRIPT_FILE=`basename $0`

COLOR_INFO='\033[0;36m'
COLOR_NONE='\033[0m'

source ${SCRIPT_PATH}/lib/query_problem.sh
# Java base package
JAVA_BASE_PACKAGE=./src/main/java/org/example

function usage() {
    echo -e "Usage: ${0} [url]"
    echo -e ""
    echo -e "Example:"
    echo -e ""
    echo -e "   Running workflow for a problem"
    echo -e "   ${0} https://leetcode.com/problems/largest-number/"
    echo -e ""
}

# Handle [url] param
if [ $# -lt 1 ] || [[ "${1}" != ${LEETCODE_NEW_URL}* ]] && [[ "${1}" != ${LEETCODE_OLD_URL}* ]]; then
    usage
    exit 255
fi

if [[ "${1}" == ${LEETCODE_OLD_URL}* ]]; then
    LEETCODE_URL=${LEETCODE_OLD_URL}
fi

platform=`detect_os`
leetcode_url=$1

# Step 1: create directory
get_question_slug ${leetcode_url}
dir_name=`echo ${QUESTION_TITLE_SLUG} | awk -F '-' '{for (i=1; i<=NF; i++) printf("%s", toupper(substr($i,1,1)) substr($i,2)) }'`
# First letter lowercase
dir_name=`echo ${dir_name:0:1} | tr '[A-Z]' '[a-z]'`${dir_name:1}

mkdir -p ${JAVA_BASE_PACKAGE}/${dir_name}
echo "Step 1: Created \"${dir_name}\" package!"
cd ${JAVA_BASE_PACKAGE}/${dir_name}

# Step 2: create source file
file=`${SCRIPT_PATH}/comments.sh ${leetcode_url} | grep updated | awk '{print $1}'`
WORKING_DIR=`pwd`
SRC="${dir_name}/${file}"
echo "Step 2: Created \"${SRC}\" source file!"


# Step 3: add question 2 README.md
echo "Step 3: Edited the \"${SRC}\"!"
readme=`${SCRIPT_PATH}/readme.sh ${file} ${JAVA_BASE_PACKAGE}/${SRC}`
readme=`echo "${readme}" | head -n 1`
README_FILE="${SCRIPT_PATH}/../README.md"
echo "$readme" >> ${README_FILE}


# Step 4: generate git-commit content
echo "Step 4: Generate git-commit content!"

QUESTION_FRONTEND_ID=`echo "${readme}" | awk -F '|' '{print $2}'`
QUESTION_TITLE=`echo "${readme}" | awk -F '|' '{print $3}' | sed 's/\[/\]/' |awk -F ']' '{print $2}'`
echo -e "\n\tfeat: add ${QUESTION_FRONTEND_ID}.${QUESTION_TITLE}\n\t# You can copy above content when you already commit.\n"

echo "Done!"
