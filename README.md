## Robot
I recently found out about a class in java called `Robot` capable of moving and clicking your mouse, pressing your keyboard and looking at your screen. This is a project to see if I can write a program to play [Penguin Diner 2](https://www.coolmathgames.com/0-penguin-diner-2)


# The program
Throughout writing the program I've tried to steer away from looking at pixel RGB values and use constants for pixel coords because it will change with each screen and possibly web browser. I'm very proud of this program and it seems fairly robust. 
------------------------------------------------------------

***THE PROGRAM CAN WIN A FULL DAY***
------------------------------------------------------------

## Where I'm leaving it
The Algorythm *purposely misspelled* can complete a full day, but does have some unfortunate issues
    - If anything happens after the timer said it should there is no correcting the mistake
    - There is nothing for manuvering through the menus, except hitting `resume game` at the start
    - The algorithm can't tell what food should go where
    - If more than three pieces of food are made at a time, the extra food will never be collected
    - I never implemented `twins`, the name I gave to pairs of customers

Even with all of those bugs, I've done much better than I thought I could and I'm happy with how well I did