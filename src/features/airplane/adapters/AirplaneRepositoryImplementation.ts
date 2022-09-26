import { mapFns } from '../../../core/mapFns';
import { airplaneType } from '../models';
import { airplaneRepositoryType } from '../ports/airplaneRepository';

export class AirplaneRepositoryImplementation implements airplaneRepositoryType {
    private readonly airplanesDatabase = new Map<string, airplaneType>();

    public add(airplane: airplaneType) {
        this.airplanesDatabase.set(airplane.id, airplane);
    }

    public remove(id: string) {
        this.airplanesDatabase.delete(id);
    }

    public update(airplane: airplaneType) {
        this.airplanesDatabase.set(airplane.id, airplane);
    }

    public retrieve() {
        return mapFns.valueToArray(this.airplanesDatabase);
    }
}
