use serde::{Deserialize, Serialize};
use serde_wasm_bindgen;
use wasm_bindgen::{prelude::wasm_bindgen, JsValue};

use super::cartesian_point_api::CartesianPointAPI;
use super::plane_point_api::PlanePointAPI;

#[derive(Serialize, Deserialize)]
struct ScalonateArguments {
    point: PlanePointAPI,
    factor: CartesianPointAPI,
}

#[allow(dead_code)]
#[wasm_bindgen]
pub fn scalonate(val: JsValue) -> Result<JsValue, JsValue> {
    let args: ScalonateArguments = serde_wasm_bindgen::from_value(val)?;
    let point = args.point.to_point();
    let factor = args.factor.to_point();
    let translated_value = point * factor;
    let serializable = CartesianPointAPI::from_point(translated_value);

    Ok(serde_wasm_bindgen::to_value(&serializable)?)
}

#[cfg(test)]
mod scalonate_test {
    use crate::api::planes::Planes;

    use super::*;

    #[test]
    fn return_the_value() {
        let value_to_scalonate = ScalonateArguments {
            point: PlanePointAPI {
                plane: Planes::CARTESIAN,
                a: "1.1974374286".to_string(),
                b: "-4.38637437".to_string(),
            },
            factor: CartesianPointAPI {
                x: "-3.28".to_string(),
                y: "8.37".to_string(),
            },
        };
        let expected_return = CartesianPointAPI {
            x: "-2.8174374286".to_string(),
            y: "8.75637437".to_string(),
        };

        assert_eq!(
            scalonate(serde_wasm_bindgen::to_value(&value_to_scalonate).unwrap()).unwrap(),
            serde_wasm_bindgen::to_value(&expected_return).unwrap()
        )
    }
}
