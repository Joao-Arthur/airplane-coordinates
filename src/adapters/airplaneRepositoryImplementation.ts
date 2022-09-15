import { airplaneType, unsavedAirplane } from '../entities/airplane';
import { airplaneRepository } from '../ports/airplaneRepository';

function add(airplane: unsavedAirplane): void {

}

function remove(id: string):void {

}

function update(airplane: airplaneType): void {

}

function retrieve(): readonly airplaneType[] {
    return ([] as airplaneType[]);
}

export const airplaneRepositoryImplementation: airplaneRepository = {
    add,
    remove,
    update,
    retrieve,
};
