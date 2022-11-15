import { LoggerImplementationProxy } from '../../logger/adapters/LoggerImplementationProxy';
import { messageType } from '../../logger/model';
import { uniqueIdentifierBig } from '../../uniqueIdentifier/adapters/uniqueIdentifierBig';
import { UniqueIdentifierImplementation } from '../../uniqueIdentifier/adapters/UniqueIdentifierImplementation';
import { AirplaneRepositoryImplementationProxy } from '../adapters/AirplaneRepositoryImplementationProxy';
import { airplaneType } from '../models';
import { addAirplaneService, airplaneParamsType } from '../useCases/addAirplane';
import { airplanesCloseToAirportService } from '../useCases/airplanesCloseToAirport';
import { airplanesCloseToEachOtherService } from '../useCases/airplanesCloseToEachOther';
import { airplanesInRouteOfCollisionService } from '../useCases/airplanesInRouteOfCollision';
import { deleteAirplaneService } from '../useCases/deleteAirplane';
import { rotateAirplaneCoordinatesService } from '../useCases/rotateAirplaneCoordinates';
import { scalonateAirplaneCoordinatesService } from '../useCases/scalonateAirplaneCoordinates';
import { translateAirplaneCoordinatesService } from '../useCases/translateAirplaneCoordinates';

export type gatewayAddAirplaneParamsType = {
    readonly airplaneParams: airplaneParamsType;
};

export type gatewayDeleteAirplaneParamsType = {
    readonly selectedIds: readonly airplaneType['id'][];
};

export type gatewayAirplanesCloseToAirportParamsType = {
    readonly maxDistance: number;
};

export type gatewayAirplanesCloseToEachOtherParamsType = {
    readonly maxDistance: number;
};

export type gatewayAirplanesInRouteOfCollisionParamsType = {
    readonly maxTime: number;
};

export type gatewayRotateAirplaneCoordinatesParamsType = {
    readonly selectedIds: readonly airplaneType['id'][];
    readonly angle: string;
    readonly centerOfRotation: {
        readonly x: string;
        readonly y: string;
    }
};

export type gatewayScalonateAirplaneCoordinatesParamsType = {
    readonly selectedIds: readonly airplaneType['id'][];
    readonly factor: {
        readonly x: string;
        readonly y: string;
    }
};

export type gatewayTranslateAirplaneCoordinatesParamsType = {
    readonly selectedIds: readonly airplaneType['id'][];
    readonly factor: {
        readonly x: string;
        readonly y: string;
    }
};

export class AirplaneGateway {
    private readonly logger = new LoggerImplementationProxy(uniqueIdentifierBig);
    private readonly airplaneRepository = new AirplaneRepositoryImplementationProxy();
    private readonly uniqueIdentifier = new UniqueIdentifierImplementation();

    public addAirplane({ airplaneParams }: gatewayAddAirplaneParamsType) {
        addAirplaneService({
            logger: this.logger,
            airplaneRepository: this.airplaneRepository,
            uniqueIdentifier: () => this.uniqueIdentifier.getUnique(),
            airplaneParams,
        });
    }

    public deleteAirplanes({ selectedIds }: gatewayDeleteAirplaneParamsType) {
        deleteAirplaneService({
            logger: this.logger,
            airplaneRepository: this.airplaneRepository,
            selectedIds,
        });
    }

    public getAirplanesCloseToAirport({ maxDistance }: gatewayAirplanesCloseToAirportParamsType) {
        airplanesCloseToAirportService({
            logger: this.logger,
            airplaneRepository: this.airplaneRepository,
            maxDistance,
        });
    }

    public getAirplanesCloseToEachOther({ maxDistance }: gatewayAirplanesCloseToEachOtherParamsType) {
        airplanesCloseToEachOtherService({
            logger: this.logger,
            airplaneRepository: this.airplaneRepository,
            maxDistance,
        });
    }

    public getAirplanesInRouteOfCollision({ maxTime }: gatewayAirplanesInRouteOfCollisionParamsType) {
        airplanesInRouteOfCollisionService({
            logger: this.logger,
            airplaneRepository: this.airplaneRepository,
            maxTime,
        });
    }

    public rotateAirplanesCoordinates({
        selectedIds,
        angle,
        centerOfRotation,
    }: gatewayRotateAirplaneCoordinatesParamsType) {
        rotateAirplaneCoordinatesService({
            logger: this.logger,
            airplaneRepository: this.airplaneRepository,
            selectedIds,
            angle,
            centerOfRotation,
        });
    }

    public scalonateAirplanesCoordinates({
        selectedIds,
        factor,
    }: gatewayScalonateAirplaneCoordinatesParamsType) {
        scalonateAirplaneCoordinatesService({
            logger: this.logger,
            airplaneRepository: this.airplaneRepository,
            selectedIds,
            factor,
        });
    }

    public translateAirplanesCoordinates({
        selectedIds,
        factor,
    }: gatewayTranslateAirplaneCoordinatesParamsType) {
        translateAirplaneCoordinatesService({
            logger: this.logger,
            airplaneRepository: this.airplaneRepository,
            selectedIds,
            factor,
        });
    }

    public onLogUpdated(callback: (logs: readonly messageType[]) => void) {
        this.logger.addCallback(callback);
    }

    public onRepositoryUpdated(callback: (airplanes: readonly airplaneType[]) => void) {
        this.airplaneRepository.addCallback(callback);
    }

    public clearLogs() {
        this.logger.clear();
    }
}
