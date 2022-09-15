import { airplaneType, unsavedAirplane } from '../entities/airplane';
import { airplaneRepositoryType } from '../ports/airplaneRepository';

function add(airplane: unsavedAirplane): void {

}

function remove(id: string):void {

}

function update(airplane: airplaneType): void {

}

function retrieve(): readonly airplaneType[] {
    return ([] as airplaneType[]);
}

export const airplaneRepositoryImplementation: airplaneRepositoryType = {
    add,
    remove,
    update,
    retrieve,
};
