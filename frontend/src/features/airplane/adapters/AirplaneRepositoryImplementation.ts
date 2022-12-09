import { maps } from 'funis';
import { airplaneType } from '../models';
import { airplaneRepositoryType } from '../ports/airplaneRepository';

export class AirplaneRepositoryImplementation implements airplaneRepositoryType {
    private readonly airplanesDatabase = new Map<airplaneType['id'], airplaneType>();

    public add(airplane: airplaneType) {
        this.airplanesDatabase.set(airplane.id, airplane);
    }

    public remove(id: airplaneType['id']) {
        this.airplanesDatabase.delete(id);
    }

    public updatePointById(id: airplaneType['id'], point: airplaneType['point']) {
        const airplane = this.airplanesDatabase.get(id);
        if (!airplane)
            return;
        this.airplanesDatabase.set(id, { ...airplane, point });
    }

    public retrieve() {
        return maps.values(this.airplanesDatabase);
    }
}
