import React, { useEffect, useState } from 'react';
import { useForm, Controller } from 'react-hook-form';
import { InputText } from 'primereact/inputtext';
import { Button } from 'primereact/button';
import { Dropdown } from 'primereact/dropdown';
import { Calendar } from 'primereact/calendar';
import { Password } from 'primereact/password';
import { Checkbox } from 'primereact/checkbox';
import { Dialog } from 'primereact/dialog';
import { Divider } from 'primereact/divider';
import { classNames } from 'primereact/utils';
import { SelectButton } from 'primereact/selectbutton';
import HastaneService from '../hastaneComponent/HastaneService';
import CityService from '../hastaneComponent/CityService';
import DistrictService from '../hastaneComponent/DistrictService';
import NeighborhoodService from '../hastaneComponent/NeighborhoodService';
import DepartmentService from '../hastaneComponent/DepartmentService';
import DoktorService from '../hastaneComponent/DoktorService';

import './FormDemo.css';

const RandevuAl = () => {
    const [countries, setCountries] = useState([]);
    const [showMessage, setShowMessage] = useState(false);
    const [formData, setFormData] = useState({});
    const [loading, setLoading] = useState(true)
    const [hospital, setHospital] = useState([{}])
    const [hospitalNames, setHospitalNames] = useState([{}])
    const [cityNames, setCityNames] = useState({})
    const [districtNames, setDistrictNames] = useState([{}])
    const [neighborhoodNames, setNeighborhoodNames] = useState([{}])
    const [city, setCity] = useState([{}])
    const [neighborhood, setNeighborhood] = useState([{}])
    const [district, setDistrict] = useState([{}])
    const [departmentNames, setDepartmentNames] = useState([{}])
    const [department, setDepartment] = useState([{}])
    const [doktor, setDoktor] = useState({});
    const [doktorNames, setDoktorNames] = useState({});
    // const productService = new ProductService();
    const defaultValues = {
        name: '',
        email: '',
        password: '',
        date: null,
        country: null,
        accept: false
    }
    const [value3, setValue3] = useState(null);
    const paymentOptions = [
        { name: '10:00 - 10:10' },
        { name: '10:10 - 10:20' },
        { name: '10:20 - 10:30' },
        { name: '10:30 - 10:40' },
        { name: '10:40 - 10:50' },
        { name: '10:50 - 11:00' },
        { name: '11:00 - 11:10' },
        { name: '11:10 - 11:20' },
        { name: '11:20 - 11:30' }
    ];

    const getAllCity = async () => {
        const data = await CityService.getAllCity()
        setCityNames(data)
        return data
    }

    const getAllDistrict = async () => {
        const data = await DistrictService.getAllDistrict()
        setDistrictNames(data)
        return data
    }

    const getAllNeighborhood = async () => {
        const data = await NeighborhoodService.getAllNeighborhood()
        setNeighborhoodNames(data)
        return data
    }
    const getAllHospital = async () => {
        const data = await HastaneService.getAllHastane()
        setHospitalNames(data)
        return data
    }
    const getAllDepartman = async () => {
        const data = await DepartmentService.getAllDepartman()
        setDepartmentNames(data)
        return data
    }
    const getAllDoktor = async () => {
        const data = await DoktorService.getAllDoktor()
        setDoktorNames(data)
        return data
    }


    useEffect(async () => {
        await getAllCity()
        await getAllDistrict()
        await getAllNeighborhood()
        await getAllHospital()
        await getAllDepartman()
        await getAllDoktor()
        setLoading(false)
    }, [])

    const { control, formState: { errors }, handleSubmit, reset } = useForm({ defaultValues });

    const onSubmit = (data) => {
        setFormData(data);
        setShowMessage(true);

        reset();
    };

    const getFormErrorMessage = (name) => {
        return errors[name] && <small className="p-error">{errors[name].message}</small>
    };

    const dialogFooter = <div className="p-d-flex p-jc-center"><Button label="OK" className="p-button-text" autoFocus onClick={() => setShowMessage(false)} /></div>;
    const passwordHeader = <h6>Pick a password</h6>;
    const passwordFooter = (
        <React.Fragment>
            <Divider />
            <p className="p-mt-2">Suggestions</p>
            <ul className="p-pl-2 p-ml-2 p-mt-0" style={{ lineHeight: '1.5' }}>
                <li>At least one lowercase</li>
                <li>At least one uppercase</li>
                <li>At least one numeric</li>
                <li>Minimum 8 characters</li>
            </ul>
        </React.Fragment>
    );



    if (loading) {
        return (
            <div>Veriler Yükleniyor....</div>
        )
    } else {


        return (

            <div className="form-demo">
                <Dialog visible={showMessage} onHide={() => setShowMessage(false)} position="top" footer={dialogFooter} showHeader={false} breakpoints={{ '960px': '80vw' }} style={{ width: '30vw' }}>
                    <div className="p-d-flex p-ai-center p-dir-col p-pt-6 p-px-3">
                        <i className="pi pi-check-circle" style={{ fontSize: '5rem', color: 'var(--green-500)' }}></i>
                        <h5>Randevu Alma Başarılı</h5>
                        <p style={{ lineHeight: 1.5, textIndent: '1rem' }}>
                            Sayın <b>{formData.name}</b> ; ...... Tarihinde  <b>{hospital.hospitalName}</b>  --- <b>{department.departmanName}</b> --- <b>{doktor.doktorName}</b> doktorumuzdan almış olduğunuz randevunuz sisteme kaydedilmiştir.Sağlıklı günler.
                        </p>
                    </div>
                </Dialog>

                <div className="p-d-flex p-jc-center p-p-5">
                    <div className="card p-p-9"><br />
                        <h5 className="p-text-center">Randevu Al <i className="pi pi-user" /></h5>
                        <form onSubmit={handleSubmit(onSubmit)} className="p-fluid">
                            <div className="p-field">
                                <span className="p-float-label">

                                    <Controller name="name" control={control} rules={{ required: 'Name is required.' }} render={({ field, fieldState }) => (
                                        <InputText id={field.name} {...field} autoFocus className={classNames({ 'p-invalid': fieldState.invalid })} />
                                    )} />
                                    <label htmlFor="name" className={classNames({ 'p-error': errors.name })}>Name*</label>
                                </span>
                                {getFormErrorMessage('name')}
                            </div>
                            <div className="p-field">
                                <Dropdown optionLabel="cityName" value={city} options={cityNames} onChange={(e) => setCity(e.value)} placeholder="Select a City" /><br />
                                <Dropdown optionLabel="districtName" value={district} options={districtNames.filter(e => e.cityid.cityid === city.cityid)} onChange={(e) => { setDistrict(e.value) }} placeholder="Select a District" /><br />
                                <Dropdown optionLabel="neighborhoodName" value={neighborhood} options={neighborhoodNames.filter(e => e.districtid.districtid === district.districtid)} onChange={(e) => { setNeighborhood(e.value) }} placeholder="Select a Neighborhood" /><br />
                                <Dropdown optionLabel="hospitalName" value={hospital} options={hospitalNames.filter(e => e.addressid.neighborhoodid.neighborhoodid === neighborhood.neighborhoodid)} onChange={(e) => setHospital(e.value)} placeholder="Select a Hospital" /><br />
                                <Dropdown optionLabel="departmanName" value={department} options={departmentNames} onChange={(e) => { setDepartment(e.value) }} placeholder="Select a Department" /><br />
                                <Dropdown optionLabel="doktorName" value={doktor} options={doktorNames.filter(e => e.hastane.id === hospital.id && e.departman.id === department.id)} onChange={(e) => setDoktor(e.value)} placeholder="Select a Doktor" />

                            </div>

                            <div className="p-field">
                                <span className="p-float-label">
                                    <Controller name="date" control={control} render={({ field }) => (
                                        <Calendar id={field.name} value={field.value} onChange={(e) => field.onChange(e.value)} dateFormat="yy-mm-dd" mask="99/99/9999" showIcon />
                                    )} />
                                    <label htmlFor="date">Randevu Tarihi Seçiniz</label>

                                </span>
                                <SelectButton value={value3} options={paymentOptions} onChange={(e) => setValue3(e.value)} optionLabel="name" />

                            </div>
                            <Button type="submit" label="Kaydet" className="p-mt-2" />
                        </form>
                    </div>
                </div>
            </div>
        );
    }
}

export default RandevuAl;