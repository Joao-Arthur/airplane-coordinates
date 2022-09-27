
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
    const [selectedIds, setSelectedIds] = useState<readonly string[]>([]);
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

    function handleSelect(id: string) {
        setSelectedIds(selectedIds.concat(id))
    }

    function handleUnselect(id: string) {
        setSelectedIds(selectedIds.filter(sId => sId !== id))
    }

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
                                    <Translate selectedIds={selectedIds} translateCoordinates={translateCoordinates} />
                                    <Scalonate selectedIds={selectedIds} scalonateCoordinates={scalonateCoordinates} />
                                    <Rotate selectedIds={selectedIds} rotateCoordinates={rotateCoordinates} />
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
                <AirplanesTable
                    onRepositoryUpdated={onRepositoryUpdated}
                    selectedIds={selectedIds}
                    selectId={handleSelect}
                    unselectId={handleUnselect}
                />
                <Report onLogUpdated={onLogUpdated} />
            </div>
            <div className='flex flex-col w-2/4' ref={radarContainer}>
                <Radar dimensions={dimensions} onRepositoryUpdated={onRepositoryUpdated} />
            </div>
        </>
    )
}