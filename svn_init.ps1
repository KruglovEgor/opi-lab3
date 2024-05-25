# Define the repository and main directory names
$repoName = "svn"
$mainDir = "main_dir"

# Create the SVN repository
svnadmin create $repoName

# Change directory to the SVN repository location
Set-Location $repoName
$location = (Get-Location).Path

# Create the trunk and branches directories in the SVN repository
svn mkdir -m "structure" "file:///$location/trunk" "file:///$location/branches"

# Check out the trunk to the main directory
svn checkout "file:///$location/trunk" $mainDir

# Change directory to the main directory
Set-Location $mainDir

# Create the report directory
mkdir report

# Add the new directory to SVN
svn add --force .

# Commit the new directory to SVN
svn commit -m "report dir"

# Return to the initial directory
Set-Location ../..
