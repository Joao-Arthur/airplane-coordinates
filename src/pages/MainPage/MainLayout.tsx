
import { useRef, useState } from 'react';
import { useDidMount } from 'rooks';
import { Tab } from '../../components/Tab';
import { AddAirplane } from './AddAirplane';
import { AirplanesTable } from './AirplanesTable';
import { CloseToAirport } from './CloseToAirport';
import { CloseToEachOther } from './CloseToEachOther';
import { InRouteOfCollision } from './InRouteOfCollision';
import { Radar } from './Radar';
import { Report } from './Report';
import { Rotate } from './Rotate';
import { Scalonate } from './Scalonate';
import { Translate } from './Translate';
import { useAirplanes } from './useAirplanes';

export function MainLayout() {
    const radarContainer = useRef<HTMLDivElement | null>(null);
    const [dimensions, setDimensions] = useState(0);
    const {
        add,
        getCloseToAirport,
        getCloseToEachOther,
        getInRouteOfCollision,
        rotateCoordinates,
        scalonateCoordinates,
        translateCoordinates,
        onLogUpdated,
        onRepositoryUpdated
    } = useAirplanes();

    function resize() {
        setDimensions(
            Math.min(
                (radarContainer?.current?.clientWidth || 0) - 50,
                (radarContainer?.current?.clientHeight || 0) - 50,
            )
        );
    }

    useDidMount(() => {
        resize();
        window.addEventListener('resize', resize);
        return () => window.removeEventListener('resize', resize);
    });

    return (
        <>
            <div className='flex flex-col w-1/4'>
                <Tab
                    tabs={[
                        {
                            title: 'Adicionar',
                            comp: <AddAirplane add={add} />
                        },
                        {
                            title: 'Transformar',
                            comp: (
                                <div>
                                    <Translate translateCoordinates={translateCoordinates} />
                                    <Scalonate scalonateCoordinates={scalonateCoordinates} />
                                    <Rotate rotateCoordinates={rotateCoordinates} />
                                </div>
                            )
                        },
                        {
                            title: 'Rastrear',
                            comp: (
                                <div>
                                    <CloseToAirport getCloseToAirport={getCloseToAirport} />
                                    <CloseToEachOther getCloseToEachOther={getCloseToEachOther} />
                                    <InRouteOfCollision getInRouteOfCollision={getInRouteOfCollision} />
                                </div>
                            )
                        },
                    ]}
                />
            </div>
            <div className='flex flex-col w-1/4'>
                <AirplanesTable />
                <Report onLogUpdated={onLogUpdated} />
            </div>
            <div className='flex flex-col w-2/4' ref={radarContainer}>
                <Radar dimensions={dimensions} onRepositoryUpdated={onRepositoryUpdated} />
            </div>
        </>
    )
}