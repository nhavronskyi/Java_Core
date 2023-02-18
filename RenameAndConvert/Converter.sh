#!/bin/bash

# declared a format of photos to variables
format=$(sed -n 8p /Users/nhawronsky/Documents/Work/hector/data.txt)
formatTo=$(sed -n 10p /Users/nhawronsky/Documents/Work/hector/data.txt)


echo "--> Format from: ."$format " -> ."$formatTo 

# declared a variable to count how many photos are converted
i=-1

# loop to convert all photos
for f in /Users/nhawronsky/Documents/Work/hector/renamer/*.$format; 
    do
        # using ImageMagick for formatting photos
        magick /Users/nhawronsky/Documents/Work/hector/renamer/*.$format /Users/nhawronsky/Documents/Work/hector/renamer/f.$formatTo
        
        # delete photos with old format
        rm /Users/nhawronsky/Documents/Work/hector/renamer/*.$format /Users/nhawronsky/Documents/Work/hector/renamer/*.$format
        
        # counter
        i=$((i+1))
done
 
# demonstration of converter
if [ $i == 0 ] 
then
    echo "--> There are no photos to convert"
else 
    echo "--> Photos converted: "$((i+1))
fi