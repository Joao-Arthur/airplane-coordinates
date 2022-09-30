import { LoggerImplementationProxy } from '../../logger/adapters/LoggerImplementationProxy';
import { messageType } from '../../logger/model';
import { uniqueIdentifierBig } from '../../uniqueIdentifier/adapters/uniqueIdentifierBig';
import { uniqueIdentifierImplementation } from '../../uniqueIdentifier/adapters/uniqueIdentifierImplementation';
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
    readonly id: airplaneType['id'];
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
    readonly selectedIds: readonly string[];
    readonly angle: number;
    readonly centerOfRotationX: number;
    readonly centerOfRotationY: number;
};

export type gatewayScalonateAirplaneCoordinatesParamsType = {
    readonly selectedIds: readonly string[];
    readonly x: number;
    readonly y: number;
};

export type gatewayTranslateAirplaneCoordinatesParamsType = {
    readonly selectedIds: readonly string[];
    readonly x: number;
    readonly y: number;
};

export class AirplaneGateway {
    private readonly logger = new LoggerImplementationProxy(uniqueIdentifierBig);
    private readonly airplaneRepository = new AirplaneRepositoryImplementationProxy();
    private readonly uniqueIdentifier = uniqueIdentifierImplementation;

    public addAirplane({ airplaneParams }: gatewayAddAirplaneParamsType) {
        addAirplaneService({
            logger: this.logger,
            airplaneRepository: this.airplaneRepository,
            uniqueIdentifier: this.uniqueIdentifier,
            airplaneParams,
        });
    }

    public deleteAirplane({ id }: gatewayDeleteAirplaneParamsType) {
        deleteAirplaneService({
            logger: this.logger,
            airplaneRepository: this.airplaneRepository,
            id,
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
        centerOfRotationX,
        centerOfRotationY,
    }: gatewayRotateAirplaneCoordinatesParamsType) {
        rotateAirplaneCoordinatesService({
            logger: this.logger,
            airplaneRepository: this.airplaneRepository,
            selectedIds,
            angle,
            centerOfRotationX,
            centerOfRotationY,
        });
    }

    public scalonateAirplanesCoordinates({
        selectedIds,
        x,
        y,
    }: gatewayScalonateAirplaneCoordinatesParamsType) {
        scalonateAirplaneCoordinatesService({
            logger: this.logger,
            airplaneRepository: this.airplaneRepository,
            selectedIds,
            x,
            y,
        });
    }

    public translateAirplanesCoordinates({
        selectedIds,
        x,
        y,
    }: gatewayTranslateAirplaneCoordinatesParamsType) {
        translateAirplaneCoordinatesService({
            logger: this.logger,
            airplaneRepository: this.airplaneRepository,
            selectedIds,
            x,
            y,
        });
    }

    public onLogUpdated(callback: (logs: readonly messageType[]) => void) {
        this.logger.addCallback(callback);
    }

    public onRepositoryUpdated(callback: (airplanes: readonly airplaneType[]) => void) {
        this.airplaneRepository.addCallback(callback);
    }
}
