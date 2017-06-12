using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Ds.DataAccess.EF;
namespace Ds.DataAccess.Generic
{
    public interface IStaffRepository : IGenericDataRepository<ds_nhanvien> { }
    public interface IStaffTypeRepository : IGenericDataRepository<ds_loainhanvien> { }
    public class StaffRepository : GenericDataRepository<ds_nhanvien>, IStaffRepository { }
    public class StaffTypeRepository : GenericDataRepository<ds_loainhanvien>, IStaffTypeRepository { }
}
