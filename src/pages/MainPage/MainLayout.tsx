
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

export function MainLayout() {
    const radarContainer = useRef<HTMLDivElement | null>(null);
    const [dimensions, setDimensions] = useState(0);

    function resize() {
        setDimensions(
            Math.min(
                (radarContainer?.current?.clientWidth || 0) - 50,
                (radarContainer?.current?.clientHeight || 0) - 50,
            ),
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
                            comp: <AddAirplane />,
                        },
                        {
                            title: 'Transformar',
                            comp: (
                                <div>
                                    <Translate />
                                    <Scalonate />
                                    <Rotate />
                                </div>
                            ),
                        },
                        {
                            title: 'Rastrear',
                            comp: (
                                <div>
                                    <CloseToAirport />
                                    <CloseToEachOther />
                                    <InRouteOfCollision />
                                </div>
                            ),
                        },
                    ]}
                />
            </div>
            <div className='flex flex-col w-2/4' ref={radarContainer}>
                <Radar dimensions={dimensions} />
            </div>
            <div className='flex flex-col w-1/4 flex-0 h-full'>
                <AirplanesTable />
                <Report />
            </div>
        </>
    );
}
