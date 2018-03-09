# visual-novel-engine

## Clone the repo

The wiki is embedded into the repo, but on a normal `clone` git doesn't load it. To load both, use:
    $ git clone --recursive ADDRESS
(if you use SSH, the address will be `git@github.com:CLOVIS-AI/visual-novel-engine.git`, otherwise use `https://github.com/clovis-ai/visual-novel-engine.git`)

If you cloned without the `--recursive` flag, you can load the wiki with:
    $ git submodule init
    $ git submodule update

If you update the wiki:
    $ cd wiki
    $ git checkout -b work
    # do your changes
    $ git push
    $ cd ..
    $ git submodule update

## Branches

 - `master` : Main branch, contains stable versions.
 - `testing` : Contains pre-releases (possibly unstable versions).
 - `dev` : Work in progress. You can go to the "Projects" tab on GitHub to see the progress until the next merge of this branch into `testing`.

Collaborators should only push or make pull requests to `testing`. The only commits allowed in `testing` are bug-fixes. Developpement should be made in an other branch (for instance the `dev` branch).
