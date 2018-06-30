# app-prog

#The git workflow

Before starting to work:
1. ``git stash`` in case you have unstaged changes
2. ``git pull`` or ``git pull origin master`` to pull remote changes
3. ``git stash pop`` put your unstaged changes back to your local space
4. if merge conflicts occur, see below

After work is done:
1. build project and test!!
2. check for unecessary changes (e.g. whitespace, TODOs...)
3. ``git add --all`` to add everything or ``git add [filepath]`` to add specific files
4. ``git commit -m "your commitmessage here"`` commit your work
5. ``git push`` or git push origin master`` push your work

If merge conflicts occur:
1. keep calm
2. Use Android Studios built in Tool (VCS -> Git -> Resolve Conflicts...) to resolve the conflicts or
3. Search for the markers (like <<<HEAD<<<<) and resolve the conflicts by hand
4. add and commit the changes (merging always creates a new merge commit)
5. continue with your work

