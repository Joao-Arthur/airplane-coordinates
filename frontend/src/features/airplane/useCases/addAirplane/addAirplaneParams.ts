import { loggerRepositoryType } from '../../../logger/ports/loggerRepository';
import { uniqueIdentifierType } from '../../../uniqueIdentifier/ports/uniqueIdentifier';
import { airplaneRepositoryType } from '../../ports/airplaneRepository';

export type airplaneParamsType = {
    readonly speed: number;
    readonly direction: number;
    readonly type: 'CARTESIAN' | 'POLAR';
    readonly a: number;
    readonly b: number;
};

export type addAirplaneParamsType = {
    readonly logger: loggerRepositoryType;
    readonly uniqueIdentifier: uniqueIdentifierType;
    readonly airplaneRepository: airplaneRepositoryType;
    readonly airplaneParams: airplaneParamsType;
};
