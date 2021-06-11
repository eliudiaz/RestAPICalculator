git config --global user.email "cicd_user@ymcaret.org"
git config --global user.name "cicd_user"
git fetch --all
git checkout -b develop origin/develop
#git checkout develop
mvn -B -e -Dmaven.test.skip=true gitflow:feature-start -DfeatureName=cicd-brn
mvn -B -e  -Dmaven.test.skip=true gitflow:feature-finish -DfeatureBranch=feature/cicd-brn -P skip_exec_bash