import { mapFns } from '../../../core/mapFns';
import { savedAirplaneType } from '../models';
import { airplaneRepositoryType } from '../ports/airplaneRepository';

export class AirplaneRepositoryImplementation implements airplaneRepositoryType {
    private readonly airplanesDatabase = new Map<savedAirplaneType['id'], savedAirplaneType>();

    public add(airplane: savedAirplaneType) {
        this.airplanesDatabase.set(airplane.id, airplane);
    }

    public remove(id: savedAirplaneType['id']) {
        this.airplanesDatabase.delete(id);
    }

    public update(airplane: savedAirplaneType) {
        this.airplanesDatabase.set(airplane.id, airplane);
    }

    public retrieve() {
        return mapFns.valueToArray(this.airplanesDatabase);
    }
}
