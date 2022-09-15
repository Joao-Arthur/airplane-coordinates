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

type paramsType = {
    readonly logger: loggerType,
    readonly airplaneRepository: airplaneRepositoryType,
    readonly airplaneParams: airplaneParamsType,
};

export type addAirplane = (params: paramsType) => void;
