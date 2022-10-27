import { loggerRepositoryType } from '../../../logger/ports/loggerRepository';
import { uniqueIdentifierType } from '../../../uniqueIdentifier/ports/uniqueIdentifier';
import { airplaneRepositoryType } from '../../ports/airplaneRepository';

type polarType = {
    type: 'polar';
    readonly x: undefined;
    readonly y: undefined;
    readonly radius: number;
    readonly angle: number;
}

type cartesianPolar = {
    type: 'cartesian';
    readonly x: number;
    readonly y: number;
    readonly radius: undefined;
    readonly angle: undefined;
}

export type airplaneParamsType = {
    readonly speed: number;
    readonly direction: number;
} & (polarType | cartesianPolar);

export type addAirplaneParamsType = {
    readonly logger: loggerRepositoryType;
    readonly uniqueIdentifier: uniqueIdentifierType;
    readonly airplaneRepository: airplaneRepositoryType;
    readonly airplaneParams: airplaneParamsType;
};
