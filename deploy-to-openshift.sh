mkdir -p build/deploy
cd build/deploy
ssh-keyscan serenitydocs-wakaleo.rhcloud.com >> ~/.ssh/known_hosts
git clone ssh://$OPENSHIFT_KEY@serenitydocs-wakaleo.rhcloud.com/~/git/serenitydocs.git/
cp -Rf ../asciidoc/* serenitydocs/
cd serenitydocs
git add .
git commit -a -m"Automated release"
git push