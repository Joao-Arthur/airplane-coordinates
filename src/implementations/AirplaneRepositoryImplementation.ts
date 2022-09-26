import { mapFns } from '../core/mapFns';
import { airplaneType } from '../models/airplane';
import { airplaneRepositoryType } from '../models/airplaneRepository';
import { dispatcherType } from '../models/dispatcher';

export class AirplaneRepositoryImplementation implements airplaneRepositoryType, dispatcherType<readonly airplaneType[]> {
    private callbacks: ((payload: readonly airplaneType[]) => void)[] = [];
    private readonly airplanesDatabase = new Map<string, airplaneType>();

    public add(airplane: airplaneType) {
        this.airplanesDatabase.set(airplane.id, airplane);
        this.dispatch();
    }

    public remove(id: string) {
        this.airplanesDatabase.delete(id);
        this.dispatch();
    }

    public update(airplane: airplaneType) {
        this.airplanesDatabase.set(airplane.id, airplane);
        this.dispatch();
    }

    public retrieve() {
        return mapFns.valueToArray(this.airplanesDatabase);
    }

    public dispatch() {
        const payload = this.retrieve();
        this.callbacks.forEach(cb => cb(payload));
    }

    public addCallback(callback: (payload: readonly airplaneType[]) => void) {
        this.callbacks = this.callbacks.concat(callback);
    }
}
