mkdir -p build/deploy
cd build/deploy
ssh-keyscan serenitydocs-wakaleo.rhcloud.com >> ~/.ssh/known_hosts
git clone ${GIT_REPO}
cp -Rf ../asciidoc/* serenitydocs/
cd serenitydocs
git add .
git commit -a -m"Automated release"
git push