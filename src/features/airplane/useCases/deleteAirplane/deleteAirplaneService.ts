import { deleteAirplaneBusiness } from "./deleteAirplaneBusiness";
import { deleteAirplaneParamsType } from "./deleteAirplaneParams";

export function deleteAirplaneService({
    logger,
    airplaneRepository,
    id
}: deleteAirplaneParamsType) {
    const airplanes = airplaneRepository.retrieve();
    try {
        deleteAirplaneBusiness({ airplanes, airplaneToDelete: id });
        airplaneRepository.remove(id);
    } catch (error) {
        if (error instanceof Error)
            logger.error(`Erro ao remover avião: ${error.message}`);
    }
}
