git config --global user.email "cicd_user@ymcaret.org"
git config --global user.name "cicd_user"
git fetch --all
git checkout -b master origin/master
mvn -B -e gitflow:release-start -Dmaven.test.skip=true
mvn -B -e gitflow:release-finish -Dmaven.test.skip=true -P skip_exec_bash
