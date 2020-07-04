# csvparser

Sequentially reads T-Mobile Call and Messaging CSV records, and writes the combined data onto an SQLite database.

Refers to a look-up table to populate names for each record.

Messaging offset by +3 hours to compensate for Eastern Standard Time.

Performance is at around 100 records per second.
