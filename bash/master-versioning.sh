git config --global user.email "eliudiaz@gmail.com"
git config --global user.name "eliudiaz"
git config --global url."git@github.com:".insteadOf "https://github.com/"
git fetch --all
git checkout -b master origin/master
mvn -B -e gitflow:release-start -Dmaven.test.skip=true
mvn -B -e gitflow:release-finish -Dmaven.test.skip=true -P skip_exec_bash
