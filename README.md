# musicOrganiserSQL
University project to organise a music collection, this time improved

This is very similar to my previous musicOrganiser, hoowever there is a MySQL database that stores the music that has been added that is able to run on the localhost. Similarly, entries can be deleted from the table too.

The database connects straight from the localhost on the default MySQL port of 3306 - the username is root and there is no password - the program connects to a table inside of the database (music.sql) called music

I’ve also include a external .jar that you might need to add to the Frame class, as I needed to do this to get jdbc to run.
