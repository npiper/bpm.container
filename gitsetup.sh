#/bin/sh

# Check if our github project is set up
response=$(curl --write-out %{http_code} --silent --output /dev/null https://github.com/npiper/bpm.container)

# Check status code
if [[ "$response" -ne 200 ]] ; then
  echo "bpm.container repository has not been created - to create try this line \n curl -u 'npiper' https://api.github.com/user/repos -d '{\"name\":\"bpm.container\"}'"
  exit 1;
fi

# Initialise repository
git init
git add . && git commit -am "initial commit"
git remote add origin https://github.com/npiper/bpm.container.git
git push --set-upstream origin master

# Create 'develop' branch & push to repo
git branch develop
git checkout develop
git add .
git commit -m "adding a change from the develop branch"
git checkout master
git push origin develop

# create gh-pages branch
git checkout --orphan gh-pages
git rm -rf .
touch README.md
git add README.md
git commit -m 'initial gh-pages commit'
git push origin gh-pages