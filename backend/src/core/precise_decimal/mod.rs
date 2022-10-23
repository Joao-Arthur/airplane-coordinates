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

impl std::ops::Sub<PreciseDecimal> for PreciseDecimal {
    type Output = PreciseDecimal;

    fn sub(self, other: PreciseDecimal) -> PreciseDecimal {
        let self_decimal = Decimal::from_str(self.value.as_str()).unwrap();
        let other_decimal = Decimal::from_str(other.value.as_str()).unwrap();

        return PreciseDecimal {
            value: (self_decimal - other_decimal).to_string(),
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

impl std::ops::Div<PreciseDecimal> for PreciseDecimal {
    type Output = PreciseDecimal;

    fn div(self, other: PreciseDecimal) -> PreciseDecimal {
        let self_decimal = Decimal::from_str(self.value.as_str()).unwrap();
        let other_decimal = Decimal::from_str(other.value.as_str()).unwrap();

        return PreciseDecimal {
            value: (self_decimal / other_decimal).to_string(),
        };
    }
}

impl std::ops::Rem<PreciseDecimal> for PreciseDecimal {
    type Output = PreciseDecimal;

    fn rem(self, other: PreciseDecimal) -> PreciseDecimal {
        let self_decimal = Decimal::from_str(self.value.as_str()).unwrap();
        let other_decimal = Decimal::from_str(other.value.as_str()).unwrap();

        return PreciseDecimal {
            value: (self_decimal % other_decimal).to_string(),
        };
    }
}

#[cfg(test)]
mod test_precise_decimal {
    use super::*;

    #[test]
    fn sum() {
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
    fn subtract() {
        assert_eq!(
            PreciseDecimal {
                value: "6".to_string()
            } - PreciseDecimal {
                value: "4".to_string()
            },
            PreciseDecimal {
                value: "2".to_string()
            }
        );
        assert_eq!(
            PreciseDecimal {
                value: "1".to_string()
            } - PreciseDecimal {
                value: "-1".to_string()
            },
            PreciseDecimal {
                value: "2".to_string()
            },
        );
        assert_eq!(
            PreciseDecimal {
                value: "4".to_string()
            } - PreciseDecimal {
                value: "4".to_string()
            },
            PreciseDecimal {
                value: "0".to_string()
            },
        );
        assert_eq!(
            PreciseDecimal {
                value: "-1".to_string()
            } - PreciseDecimal {
                value: "-1".to_string()
            },
            PreciseDecimal {
                value: "0".to_string()
            },
        );
        assert_eq!(
            PreciseDecimal {
                value: "4".to_string()
            } - PreciseDecimal {
                value: "7".to_string()
            },
            PreciseDecimal {
                value: "-3".to_string()
            },
        );
        assert_eq!(
            PreciseDecimal {
                value: "0".to_string()
            } - PreciseDecimal {
                value: "3".to_string()
            },
            PreciseDecimal {
                value: "-3".to_string()
            },
        );
        assert_eq!(
            PreciseDecimal {
                value: "7".to_string()
            } - PreciseDecimal {
                value: "7".to_string()
            },
            PreciseDecimal {
                value: "0".to_string()
            },
        );
        assert_eq!(
            PreciseDecimal {
                value: "3".to_string()
            } - PreciseDecimal {
                value: "3".to_string()
            },
            PreciseDecimal {
                value: "0".to_string()
            },
        );
    }

    #[test]
    fn multiply() {
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

    #[test]
    fn divide() {
        assert_eq!(
            PreciseDecimal {
                value: "8".to_string()
            } / PreciseDecimal {
                value: "4".to_string()
            },
            PreciseDecimal {
                value: "2".to_string()
            },
        );
        assert_eq!(
            PreciseDecimal {
                value: "-2".to_string()
            } / PreciseDecimal {
                value: "-1".to_string()
            },
            PreciseDecimal {
                value: "2".to_string()
            },
        );
        assert_eq!(
            PreciseDecimal {
                value: "0".to_string()
            } / PreciseDecimal {
                value: "4".to_string()
            },
            PreciseDecimal {
                value: "0".to_string()
            },
        );
        assert_eq!(
            PreciseDecimal {
                value: "0".to_string()
            } / PreciseDecimal {
                value: "-1".to_string()
            },
            PreciseDecimal {
                value: "0".to_string()
            },
        );
        assert_eq!(
            PreciseDecimal {
                value: "-21".to_string()
            } / PreciseDecimal {
                value: "7".to_string()
            },
            PreciseDecimal {
                value: "-3".to_string()
            },
        );
        assert_eq!(
            PreciseDecimal {
                value: "-9".to_string()
            } / PreciseDecimal {
                value: "3".to_string()
            },
            PreciseDecimal {
                value: "-3".to_string()
            },
        );
        assert_eq!(
            PreciseDecimal {
                value: "0".to_string()
            } / PreciseDecimal {
                value: "7".to_string()
            },
            PreciseDecimal {
                value: "0".to_string()
            },
        );
        assert_eq!(
            PreciseDecimal {
                value: "0".to_string()
            } / PreciseDecimal {
                value: "3".to_string()
            },
            PreciseDecimal {
                value: "0".to_string()
            },
        );
    }

    #[test]
    fn division_remainder() {
        assert_eq!(
            PreciseDecimal {
                value: "-100.277".to_string()
            } % PreciseDecimal {
                value: "360".to_string()
            },
            PreciseDecimal {
                value: "-100.277".to_string()
            }
        );
        assert_eq!(
            PreciseDecimal {
                value: "360".to_string()
            } % PreciseDecimal {
                value: "360".to_string()
            },
            PreciseDecimal {
                value: "0".to_string()
            }
        );
        assert_eq!(
            PreciseDecimal {
                value: "720.111".to_string()
            } % PreciseDecimal {
                value: "360".to_string()
            },
            PreciseDecimal {
                value: "0.111".to_string()
            }
        );
        assert_eq!(
            PreciseDecimal {
                value: "0".to_string()
            } % PreciseDecimal {
                value: "360".to_string()
            },
            PreciseDecimal {
                value: "0".to_string()
            }
        );
    }

    #[test]
    fn precise_calculations() {
        assert_eq!(
            PreciseDecimal {
                value: "0.1".to_string()
            } + PreciseDecimal {
                value: "0.2".to_string()
            },
            PreciseDecimal {
                value: "0.3".to_string()
            },
        );
        assert_eq!(
            PreciseDecimal {
                value: "0.1234567890123456789012345678901".to_string()
            } + PreciseDecimal {
                value: "0.1234321003123432100312343210036".to_string()
            },
            PreciseDecimal {
                value: "0.2468888893246888889324688889".to_string()
            },
        );
        assert_eq!(
            PreciseDecimal {
                value: "0.8937593473846237864238745".to_string()
            } * PreciseDecimal {
                value: "0.6986723567253716276345786345".to_string()
            },
            PreciseDecimal {
                value: "0.6244449495825452115604125485".to_string()
            },
        );
        assert_eq!(
            PreciseDecimal {
                value: "0.6244449495825452115604125485".to_string()
            } / PreciseDecimal {
                value: "0.8937593473846237864238745".to_string()
            },
            PreciseDecimal {
                value: "0.6986723567253716276345786345".to_string()
            },
        );
    }
}
