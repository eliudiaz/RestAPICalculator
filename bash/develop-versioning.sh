git config --global user.email "eliudiaz@gmail.com"
git config --global user.name "eliudiaz"
git config --global url."git@github.com:".insteadOf "https://github.com/"
git fetch --all
git checkout -b develop origin/develop
#git checkout develop
mvn -B -e -Dmaven.test.skip=true gitflow:feature-start -DfeatureName=cicd-brn
mvn -B -e  -Dmaven.test.skip=true gitflow:feature-finish -DfeatureBranch=feature/cicd-brn -P skip_exec_bash