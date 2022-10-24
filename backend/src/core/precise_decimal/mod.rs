mod custom_operations;
mod standard_operations;

#[derive(PartialEq, Debug, Clone)]
pub struct PreciseDecimal {
    pub value: String,
}

impl PreciseDecimal {
    pub fn from_string(value: String) -> PreciseDecimal {
        PreciseDecimal { value }
    }

    pub fn from_str(value: &str) -> PreciseDecimal {
        PreciseDecimal {
            value: value.to_string(),
        }
    }

    pub fn from_int(value: isize) -> PreciseDecimal {
        PreciseDecimal {
            value: value.to_string(),
        }
    }
}

#[cfg(test)]
mod test_precise_decimal {
    use super::*;

    #[test]
    fn from_values() {
        assert_eq!(
            PreciseDecimal::from_string(String::from("28.37185")),
            PreciseDecimal {
                value: "28.37185".to_string()
            }
        );
        assert_eq!(
            PreciseDecimal::from_str("-1046.438682"),
            PreciseDecimal {
                value: "-1046.438682".to_string()
            }
        );
        assert_eq!(
            PreciseDecimal::from_int(983),
            PreciseDecimal {
                value: "983".to_string()
            }
        );
        assert_eq!(
            PreciseDecimal::from_int(-4),
            PreciseDecimal {
                value: "-4".to_string()
            }
        );
    }
}
