import { airplaneType } from "../models/airplane";
import { messageType } from "../models/message";
import { addAirplaneService } from "../useCases/addAirplane";
import { airplanesCloseToAirportService } from "../useCases/airplanesCloseToAirport";
import { airplanesCloseToEachOtherService } from "../useCases/airplanesCloseToEachOther";
import { airplanesInRouteOfCollisionService } from "../useCases/airplanesInRouteOfCollision/airplanesInRouteOfCollisionService";
import { rotateAirplaneCoordinatesService } from "../useCases/rotateAirplaneCoordinates";
import { scalonateAirplaneCoordinatesService } from "../useCases/scalonateAirplaneCoordinates";
import { translateAirplaneCoordinatesService } from "../useCases/translateAirplaneCoordinates";
import { AirplaneRepositoryImplementation } from "./AirplaneRepositoryImplementation";
import { DispatcherImplementation } from "./DispatcherImplementation";
import { LoggerImplementation } from "./LoggerImplementation";
import { uniqueIdentifierBig } from "./uniqueIdentifierBig";
import { uniqueIdentifierImplementation } from "./uniqueIdentifierImplementation";

export class AirplanesImplementation {
    private readonly logger = new LoggerImplementation(uniqueIdentifierBig);
    private readonly airplaneRepository = new AirplaneRepositoryImplementation();
    private readonly uniqueIdentifier = uniqueIdentifierImplementation;
    private readonly logDispatcher = new DispatcherImplementation(() => this.logger.retrieve());
    private readonly airplanesDispatcher = new DispatcherImplementation(() => this.airplaneRepository.retrieve());

    public addAirplane(airplaneParams: { x: number; y: number; radius: number; angle: number; speed: number; direction: number; }) {
        addAirplaneService({
            logger: this.logger,
            airplaneRepository: this.airplaneRepository,
            uniqueIdentifier: this.uniqueIdentifier,
            airplaneParams
        });
        this.airplanesDispatcher.dispatch();
        this.logDispatcher.dispatch();
    }

    public getAirplanesCloseToAirport(maxDistance: number) {
        airplanesCloseToAirportService({
            logger: this.logger,
            airplaneRepository: this.airplaneRepository,
            maxDistance
        });
        this.airplanesDispatcher.dispatch();
        this.logDispatcher.dispatch();
    }

    public getAirplanesCloseToEachOther(maxDistance: number) {
        airplanesCloseToEachOtherService({
            logger: this.logger,
            airplaneRepository: this.airplaneRepository,
            maxDistance
        });
        this.airplanesDispatcher.dispatch();
        this.logDispatcher.dispatch();
    }

    public getAirplanesInRouteOfCollision(maxTime: number) {
        airplanesInRouteOfCollisionService({
            logger: this.logger,
            airplaneRepository: this.airplaneRepository,
            maxTime
        });
        this.airplanesDispatcher.dispatch();
        this.logDispatcher.dispatch();
    }

    public rotateAirplanesCoordinates(
        selectedIds: readonly string[],
        angle: number,
        centerOfRotationX: number,
        centerOfRotationY: number,
    ) {
        rotateAirplaneCoordinatesService({
            logger: this.logger,
            airplaneRepository: this.airplaneRepository,
            selectedIds,
            angle,
            centerOfRotationX,
            centerOfRotationY
        });
        this.airplanesDispatcher.dispatch();
        this.logDispatcher.dispatch();
    }

    public scalonateAirplanesCoordinates(
        selectedIds: readonly string[],
        x: number,
        y: number,
    ) {
        scalonateAirplaneCoordinatesService({
            logger: this.logger,
            airplaneRepository: this.airplaneRepository,
            selectedIds,
            x,
            y
        });
        this.airplanesDispatcher.dispatch();
        this.logDispatcher.dispatch();
    }

    public translateAirplanesCoordinates(
        selectedIds: readonly string[],
        x: number,
        y: number,
    ) {
        translateAirplaneCoordinatesService({
            logger: this.logger,
            airplaneRepository: this.airplaneRepository,
            selectedIds,
            x,
            y
        });
        this.airplanesDispatcher.dispatch();
        this.logDispatcher.dispatch();
    }

    public onLogUpdated(callback: (logs: readonly messageType[]) => void) {
        this.logDispatcher.addCallback(callback);
    }

    public onRepositoryUpdated(callback: (airplanes: readonly airplaneType[]) => void) {
        this.airplanesDispatcher.addCallback(callback);
    }
}