# Aiplane Coordinates

Projeto final da disciplina de computação gráfica.

# Backend

Projeto em webassembly escrito em rust que realiza os cálculos de ponto flutuante com precisão de até 28 casas decimais.

# Fronend

Projeto em react que se integra ao webassembly para poder executar os cálculos e renderizar os aviões



# TODO

## fix SIN and COS operations

open issue on rust-decimal about this problem

## fix ATAN operation

look for a trigonometrical way to do that without f64 variables

## fix api rotate

even if the passed value is a POLAR one, the result is always a CARTESIAN one

## fix api scalonate

even if the passed value is a POLAR one, the result is always a CARTESIAN one

## fix api translate

even if the passed value is a POLAR one, the result is always a CARTESIAN one

## fix api architecture

separate the api in two layers: wasm serialization and deserialization and business level. only the business level can be tested on cargo