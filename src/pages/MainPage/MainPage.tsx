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

export function MainPage() {
    return (
        <>
            <div className="relative w-1/4">
                <AddAirplane />
                <Translate />
                <Scalonate />
                <Rotate />
                <CloseToAirport />
                <CloseToEachOther />
                <InRouteOfCollision />
            </div>
            <div className="relative w-1/4">
                <AirplanesTable />
                <Report />
            </div>
            <div className="relative w-1/4">
                <Radar />
            </div>
        </>
    )
}