git config --global user.email "cicd_user@ymcaret.org"
git config --global user.name "cicd_user"
git fetch --all
#git checkout -b develop origin/develop
git checkout develop
mvn -B gitflow:feature-start -DfeatureName=automatic-version gitflow:feature-finish -DfeatureName=automatic-version