DO NOT USE THIS IN IT'S CURRENT CONDITION!
It will cause crashes due to iterating over the entity array, and causing concurrent modification exceptions.
It's not currently thread-safe.
If you wish to use it, remove the loop which checks for entities on traps.
