import { addAirplaneService } from "../useCases/addAirplane";
import { airplanesCloseToAirportService } from "../useCases/airplanesCloseToAirport";
import { airplanesCloseToEachOtherService } from "../useCases/airplanesCloseToEachOther";
import { airplanesInRouteOfCollisionService } from "../useCases/airplanesInRouteOfCollision/airplanesInRouteOfCollisionService";
import { rotateAirplaneCoordinatesService } from "../useCases/rotateAirplaneCoordinates";
import { scalonateAirplaneCoordinatesService } from "../useCases/scalonateAirplaneCoordinates";
import { translateAirplaneCoordinatesService } from "../useCases/translateAirplaneCoordinates";
import { AirplaneRepositoryImplementation } from "./AirplaneRepositoryImplementation";
import { loggerImplementation } from "./loggerImplementation";
import { uniqueIdentifierImplementation } from "./uniqueIdentifierImplementation";

export class AirplanesImplementation {
    private readonly logger = loggerImplementation;
    private readonly airplaneRepository = new AirplaneRepositoryImplementation();
    private readonly uniqueIdentifier = uniqueIdentifierImplementation;

    public addAirplane(airplaneParams: { x: number; y: number; radius: number; angle: number; speed: number; direction: number; }) {
        addAirplaneService({
            logger: this.logger,
            airplaneRepository: this.airplaneRepository,
            uniqueIdentifier: this.uniqueIdentifier,
            airplaneParams
        });
    }

    public getAirplanesCloseToAirport(maxDistance: number) {
        airplanesCloseToAirportService({
            logger: this.logger,
            airplaneRepository: this.airplaneRepository,
            maxDistance
        });
    }

    public getAirplanesCloseToEachOther(maxDistance: number) {
        airplanesCloseToEachOtherService({
            logger: this.logger,
            airplaneRepository: this.airplaneRepository,
            maxDistance
        });
    }

    public getAirplanesInRouteOfCollision(maxTime: number) {
        airplanesInRouteOfCollisionService({
            logger: this.logger,
            airplaneRepository: this.airplaneRepository,
            maxTime
        });
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
    }
}