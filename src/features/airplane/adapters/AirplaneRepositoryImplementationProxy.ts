import { airplaneType } from '../models';
import { airplaneRepositoryType } from '../ports/airplaneRepository';
import { dispatcherType } from '../../dispatcher';
import { AirplaneRepositoryImplementation } from './AirplaneRepositoryImplementation';

export class AirplaneRepositoryImplementationProxy implements airplaneRepositoryType, dispatcherType {
    private callbacks: ((payload: readonly airplaneType[]) => void)[] = [];
    private readonly repository = new AirplaneRepositoryImplementation();

    public add(airplane: airplaneType) {
        this.repository.add(airplane);
        this.dispatch();
    }

    public remove(id: string) {
        this.repository.remove(id);
        this.dispatch();
    }

    public update(airplane: airplaneType) {
        this.repository.update(airplane);
        this.dispatch();
    }

    public retrieve() {
        return this.repository.retrieve();
    }

    public dispatch() {
        const payload = this.retrieve();
        this.callbacks.forEach(cb => cb(payload));
    }

    public addCallback(callback: (payload: readonly airplaneType[]) => void) {
        this.callbacks = this.callbacks.concat(callback);
    }
}
