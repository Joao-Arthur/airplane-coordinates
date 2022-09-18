import { mapFns } from '../core/mapFns';
import { airplaneType } from '../features/airplane';
import { airplaneRepositoryType } from '../ports/airplaneRepository';

export class AirplaneRepositoryImplementation implements airplaneRepositoryType {
    private airplanesDatabase = new Map<string, airplaneType>();

    public add(airplane: airplaneType): void {
        this.airplanesDatabase.set(airplane.id, airplane);
    }

    public remove(id: string): void {
        this.airplanesDatabase.delete(id);
    }

    public update(airplane: airplaneType): void {
        this.airplanesDatabase.set(airplane.id, airplane);
    }

    public retrieve(): readonly airplaneType[] {
        return mapFns.valueToArray(this.airplanesDatabase);
    }
}
