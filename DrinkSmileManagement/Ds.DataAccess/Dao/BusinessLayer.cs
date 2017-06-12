using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Ds.DataAccess.Generic;
using Ds.DataAccess.EF;

namespace Ds.DataAccess.Dao
{
    public class BusinessLayer : IBusinessLayer
    {
        private readonly IStaffRepository _staffRepository;
        private readonly IStaffTypeRepository _stafftypeRepository;

        public BusinessLayer()
        {
            _staffRepository = new StaffRepository();
            _stafftypeRepository = new StaffTypeRepository();
        }


        public IList<ds_nhanvien> GetAllStaff()
        {
            return _staffRepository.GetAll();
        }

        public ds_nhanvien GetStaffByName(string name)
        {
            return _staffRepository.GetSingle(d => d.ten_nv.Equals(name), d => d.id);
        }

        public void AddStaff(params ds_nhanvien[] staff)
        {
            _staffRepository.add(staff);
        }

        public void UpdateStaff(params ds_nhanvien[] staff)
        {
            _staffRepository.update(staff);
        }

        public void RemoveStaff(params ds_nhanvien[] staff)
        {
            _staffRepository.remove(staff);
        }

        

        public void AddTypeStaff(params ds_loainhanvien[] type)
        {
            _stafftypeRepository.add(type);
        }

        public void UpdateTypeStaff(params ds_loainhanvien[] type)
        {
            _stafftypeRepository.update(type);
        }

        public void RemoveTypeStaff(params ds_loainhanvien[] type)
        {
            _stafftypeRepository.remove(type);
        }
    }
}
