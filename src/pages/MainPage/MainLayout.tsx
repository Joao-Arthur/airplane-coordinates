
import { Tab } from "../../components/Tab";
import { AddAirplane } from "./AddAirplane";
import { AirplanesTable } from "./AirplanesTable";
import { CloseToAirport } from "./CloseToAirport";
import { CloseToEachOther } from "./CloseToEachOther";
import { InRouteOfCollision } from "./InRouteOfCollision";
import { Radar } from "./Radar";
import { Report } from "./Report";
import { Rotate } from "./Rotate";
import { Scalonate } from "./Scalonate";
import { Translate } from "./Translate";

export function MainLayout() {
    return (
        <>
            <div className="flex flex-col w-1/4">
                <Tab
                    tabs={[
                        {
                            title: 'Adicionar',
                            comp: <AddAirplane />
                        },
                        {
                            title: 'Transformar',
                            comp: (
                                <div>
                                    <Translate />
                                    <Scalonate />
                                    <Rotate />
                                </div>
                            )
                        },
                        {
                            title: 'Rastrear',
                            comp: (
                                <div>
                                    <CloseToAirport />
                                    <CloseToEachOther />
                                    <InRouteOfCollision />
                                </div>
                            )
                        },
                    ]}
                />
            </div>
            <div className="flex flex-col w-1/4">
                <AirplanesTable />
                <Report />
            </div>
            <div className="flex flex-col w-2/4">
                <Radar />
            </div>
        </>
    )
}