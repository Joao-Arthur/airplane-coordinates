# fix SIN and COS operations

open issue on rust-decimal about this problem

# fix ATAN operation

look for a trigonometrical way to do that without f64 variables

# fix api rotate

even if the passed value is a POLAR one, the result is always a CARTESIAN one

# fix api scalonate

even if the passed value is a POLAR one, the result is always a CARTESIAN one

# fix api translate

even if the passed value is a POLAR one, the result is always a CARTESIAN one

# fix api architecture

separate the api in two layers: wasm serialization and deserialization and business level. only the business level can be tested on cargo