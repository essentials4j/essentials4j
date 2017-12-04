#!/usr/bin/env bash

# Run from project root

readonly JEKYLL_ENV=${1:-development} # e.g. production

echo "Jekyll env: $JEKYLL_ENV"

docker run -it --rm -p 4000:4000 -e JEKYLL_ENV="$JEKYLL_ENV" -v $PWD:/srv/jekyll jekyll/jekyll jekyll serve -s jekyll -d docs
