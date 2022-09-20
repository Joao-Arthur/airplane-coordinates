export function Report() {
    const reports = [
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit',
        'Nam vehicula leo enim. Mauris odio ipsum, faucibus ac massa',
        'varius convallis risus. Nullam in tempus dui, a',
        'egestas neque. Donec dignissim ex eu justo pharetra, quis',
        'sagittis nibh suscipit. Quisque neque sem, venenatis id lacus sed',
        'sagittis blandit lacus. Interdum et malesuada fames ac ante ipsum',
        'primis in faucibus. Vivamus pretium faucibus odio, non dapibus',
        'Vivamus ipsum leo, finibus eget porta in, lobortis at velit. Vivamus',
        'sollicitudin ullamcorper congue. Maecenas placerat',
        'leo sit amet mollis pharetra, odio quam',
        'ultricies risus, eget rutrum ligula velit at orci. Mauris sollicitudin purus',
    ]

    return (
        <div className="overflow-x-auto">
            <table className="min-w-full text-sm divide-y-2 divide-gray-200">
                <tbody className="divide-y divide-gray-200">
                    {reports.map(report => (
                        <tr>
                            <td className="px-4 py-2 whitespace-nowrap">{report}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div >
    )
}