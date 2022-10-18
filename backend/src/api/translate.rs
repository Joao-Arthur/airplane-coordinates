use serde::Deserialize;
use serde_wasm_bindgen;
use wasm_bindgen::{prelude::wasm_bindgen, JsValue};

use crate::core::cartesian_plane::cartesian_point::CartesianPoint;
use crate::core::cartesian_plane::translate::translate as core_translate;

use super::serializable_cartesian_point::SerializableCartesianPoint;

#[derive(Deserialize)]
pub struct Arguments {
    pub point: SerializableCartesianPoint,
    pub factor: SerializableCartesianPoint,
}

#[wasm_bindgen]
pub fn translate(val: JsValue) -> Result<JsValue, JsValue> {
    let args: Arguments = serde_wasm_bindgen::from_value(val)?;

    let returnvalue = core_translate(
        CartesianPoint {
            x: args.point.x.parse().unwrap(),
            y: args.point.y.parse().unwrap(),
        },
        CartesianPoint {
            x: args.factor.x.parse().unwrap(),
            y: args.factor.y.parse().unwrap(),
        },
    );
    let serializable = SerializableCartesianPoint {
        x: returnvalue.x.to_string(),
        y: returnvalue.y.to_string(),
    };
    Ok(serde_wasm_bindgen::to_value(&serializable)?)
}
