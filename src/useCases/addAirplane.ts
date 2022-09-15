import { airplaneRepositoryType } from '../ports/airplaneRepository';
import { loggerType } from '../ports/logger';

export type airplaneParamsType = {
    x: number;
    y: number;
    speed: number;
    direction: number;
} | {
    radius: number;
    angle: number;
    speed: number;
    direction: number;
};

export type addAirplnane = (
    airplaneRepository: airplaneRepositoryType,
    airplaneParams: airplaneParamsType,
    logger: loggerType
) => void;
