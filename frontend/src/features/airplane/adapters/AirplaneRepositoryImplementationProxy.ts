import {  savedAirplaneType } from '../models';
import { airplaneRepositoryType } from '../ports/airplaneRepository';
import { dispatcherType } from '../../dispatcher';
import { AirplaneRepositoryImplementation } from './AirplaneRepositoryImplementation';

export class AirplaneRepositoryImplementationProxy implements airplaneRepositoryType, dispatcherType {
    private callbacks: ((payload: readonly savedAirplaneType[]) => void)[] = [];
    private readonly repository = new AirplaneRepositoryImplementation();

    public add(airplane: savedAirplaneType) {
        this.repository.add(airplane);
        this.dispatch();
    }

    public remove(id: savedAirplaneType['id']) {
        this.repository.remove(id);
        this.dispatch();
    }

    public update(airplane: savedAirplaneType) {
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

    public addCallback(callback: (payload: readonly savedAirplaneType[]) => void) {
        this.callbacks = this.callbacks.concat(callback);
    }
}
