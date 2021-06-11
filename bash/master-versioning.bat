git config --global user.email "cicd_user@ymcaret.org"
git config --global user.name "cicd_user"
git fetch --all
#git checkout -b master origin/master
git checkout master
mvn -B gitflow:release-start gitflow:release-finish