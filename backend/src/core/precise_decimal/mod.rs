use rust_decimal::prelude::*;

#[derive(Debug)]
pub struct PreciseDecimal {
    pub value: String,
}

impl PartialEq for PreciseDecimal {
    fn eq(&self, other: &Self) -> bool {
        return self.value == other.value;
    }
}

impl std::ops::Add<PreciseDecimal> for PreciseDecimal {
    type Output = PreciseDecimal;

    fn add(self, other: PreciseDecimal) -> PreciseDecimal {
        let self_decimal = Decimal::from_str(self.value.as_str()).unwrap();
        let other_decimal = Decimal::from_str(other.value.as_str()).unwrap();

        return PreciseDecimal {
            value: (self_decimal + other_decimal).to_string(),
        };
    }
}

impl std::ops::Mul<PreciseDecimal> for PreciseDecimal {
    type Output = PreciseDecimal;

    fn mul(self, other: PreciseDecimal) -> PreciseDecimal {
        let self_decimal = Decimal::from_str(self.value.as_str()).unwrap();
        let other_decimal = Decimal::from_str(other.value.as_str()).unwrap();

        return PreciseDecimal {
            value: (self_decimal * other_decimal).to_string(),
        };
    }
}

#[cfg(test)]
mod test_precise_decimal {
    use super::*;

    #[test]
    fn sum_correctly() {
        assert_eq!(
            PreciseDecimal {
                value: "4".to_string()
            } + PreciseDecimal {
                value: "2".to_string()
            },
            PreciseDecimal {
                value: "6".to_string()
            }
        );
        assert_eq!(
            PreciseDecimal {
                value: "-1".to_string()
            } + PreciseDecimal {
                value: "2".to_string()
            },
            PreciseDecimal {
                value: "1".to_string()
            }
        );
        assert_eq!(
            PreciseDecimal {
                value: "4".to_string()
            } + PreciseDecimal {
                value: "0".to_string()
            },
            PreciseDecimal {
                value: "4".to_string()
            }
        );
        assert_eq!(
            PreciseDecimal {
                value: "-1".to_string()
            } + PreciseDecimal {
                value: "0".to_string()
            },
            PreciseDecimal {
                value: "-1".to_string()
            }
        );
        assert_eq!(
            PreciseDecimal {
                value: "7".to_string()
            } + PreciseDecimal {
                value: "-3".to_string()
            },
            PreciseDecimal {
                value: "4".to_string()
            }
        );
        assert_eq!(
            PreciseDecimal {
                value: "3".to_string()
            } + PreciseDecimal {
                value: "-3".to_string()
            },
            PreciseDecimal {
                value: "0".to_string()
            }
        );
        assert_eq!(
            PreciseDecimal {
                value: "7".to_string()
            } + PreciseDecimal {
                value: "0".to_string()
            },
            PreciseDecimal {
                value: "7".to_string()
            }
        );
        assert_eq!(
            PreciseDecimal {
                value: "3".to_string()
            } + PreciseDecimal {
                value: "0".to_string()
            },
            PreciseDecimal {
                value: "3".to_string()
            }
        );
    }

    #[test]
    fn multiply_correctly() {
        assert_eq!(
            PreciseDecimal {
                value: "4".to_string()
            } * PreciseDecimal {
                value: "2".to_string()
            },
            PreciseDecimal {
                value: "8".to_string()
            }
        );
        assert_eq!(
            PreciseDecimal {
                value: "-1".to_string()
            } * PreciseDecimal {
                value: "2".to_string()
            },
            PreciseDecimal {
                value: "-2".to_string()
            }
        );
        assert_eq!(
            PreciseDecimal {
                value: "4".to_string()
            } * PreciseDecimal {
                value: "0".to_string()
            },
            PreciseDecimal {
                value: "0".to_string()
            }
        );
        assert_eq!(
            PreciseDecimal {
                value: "-1".to_string()
            } * PreciseDecimal {
                value: "0".to_string()
            },
            PreciseDecimal {
                value: "0".to_string()
            }
        );
        assert_eq!(
            PreciseDecimal {
                value: "7".to_string()
            } * PreciseDecimal {
                value: "-3".to_string()
            },
            PreciseDecimal {
                value: "-21".to_string()
            }
        );
        assert_eq!(
            PreciseDecimal {
                value: "3".to_string()
            } * PreciseDecimal {
                value: "-3".to_string()
            },
            PreciseDecimal {
                value: "-9".to_string()
            }
        );
        assert_eq!(
            PreciseDecimal {
                value: "7".to_string()
            } * PreciseDecimal {
                value: "0".to_string()
            },
            PreciseDecimal {
                value: "0".to_string()
            }
        );
        assert_eq!(
            PreciseDecimal {
                value: "3".to_string()
            } * PreciseDecimal {
                value: "0".to_string()
            },
            PreciseDecimal {
                value: "0".to_string()
            }
        );
    }
}
